package engine;

import java.util.ArrayList;
import java.util.Random;
import java.io.*;

import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Disarm;
import model.effects.Dodge;
import model.effects.Effect;
import model.effects.Embrace;
import model.effects.PowerUp;
import model.effects.Root;
import model.effects.Shield;
import model.effects.Shock;
import model.effects.Silence;
import model.effects.SpeedUp;
import model.effects.Stun;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Hero;
import model.world.Villain;

/**
 * A class representing the Game itself. This class will represent the main
 * engine of the
 * game, and will ensure all game rules are followed. KImo el gaamed shambo a7la
 * ta7eya lii w 5alafawy 3al shar naawy w omar GG's
 */
public class Game {
    private Player firstPlayer;
    private Player secondPlayer;
    private boolean firstLeaderAbilityUsed;
    private boolean secondLeaderAbilityUsed;
    private static ArrayList<Champion> availableChampions;
    private static ArrayList<Ability> availableAbilities;
    private PriorityQueue turnOrder;
    private final static int BOARDHEIGHT = 5;
    private final static int BOARDWIDTH = 5;
    private Object[][] board = new Object[5][5];

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        turnOrder = new PriorityQueue(6);
        availableChampions = new ArrayList<Champion>();
        availableAbilities = new ArrayList<Ability>();
        placeChampions();
        placeCovers(); 
        
    }

    /**
     * Initializes champion positions on board, center bottom row and center upper
     * row (no corners)
     */
    private void placeChampions() {
        ArrayList<Champion> firstTeam = firstPlayer.getTeam();
        ArrayList<Champion> secondTeam = secondPlayer.getTeam();

        if (firstTeam.isEmpty() || secondTeam.isEmpty())
            return;
        // Champion of Team A and Champion of Team B
        for (int i = 0; i < 3; i++) {
            Champion firstChampion = firstTeam.get(i);
            Champion secondChampion = secondTeam.get(i);
            board[0][i + 1] = firstChampion;
            board[4][i + 1] = secondChampion;
            firstChampion.setLocation(0, i + 1);
            secondChampion.setLocation(4, i + 1);
        }
    }

    private void placeCovers() {
        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            int y = 1 + rand.nextInt(3);
            int x = rand.nextInt(5);
            while (board[y][x] != null) {
                y = 1 + rand.nextInt(3);
                x = rand.nextInt(5); 
            }
            board[y][x] = new Cover(x,y);
        }
    }

    public Object[][] getBoard() {
        return board;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public boolean isFirstLeaderAbilityUsed() {
        return firstLeaderAbilityUsed;
    }

    public boolean isSecondLeaderAbilityUsed() {
        return secondLeaderAbilityUsed;
    }

    public ArrayList<Ability> getAvailableAbilities() {
        return availableAbilities;
    }

    public PriorityQueue getTurnOrder() {
        return turnOrder;
    }

    public int getBoardheight() {
        return BOARDHEIGHT;
    }

    public int getBoardwidth() {
        return BOARDWIDTH;
    }

    /**
     * Loads abilities from CSV File into local Array
     *
     */
    public static void loadAbilities(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
        String line = br.readLine(); // DMG,Shield throw,140,4,2,DIRECTIONAL,2,150,

        while (line != null) {
            String[] attributes = line.split(",");
            String name = attributes[1];
            int cost = Integer.parseInt(attributes[2]);
            int castRange = Integer.parseInt(attributes[3]);
            int baseCoolDown = Integer.parseInt(attributes[4]);
            int requiredActionPoints = Integer.parseInt(attributes[6]);
            AreaOfEffect areaOfEffect;

            switch (attributes[5]) {
                case "DIRECTIONAL":
                    areaOfEffect = AreaOfEffect.DIRECTIONAL;
                    break;
                case "SELFTARGET":
                    areaOfEffect = AreaOfEffect.SELFTARGET;
                    break;
                case "TEAMTARGET":
                    areaOfEffect = AreaOfEffect.TEAMTARGET;
                    break;
                case "SURROUND":
                    areaOfEffect = AreaOfEffect.SURROUND;
                    break;
                default:
                    areaOfEffect = AreaOfEffect.SINGLETARGET;
                    break;
            }

            if (attributes[0].equals("CC")) {
                Effect effect;
                switch (attributes[7]) {
                    case "Disarm":
                        effect = new Disarm(Integer.parseInt(attributes[8]));
                        break;
                    case "Dodge":
                        effect = new Dodge(Integer.parseInt(attributes[8]));
                        break;
                    case "Embrace":
                        effect = new Embrace(Integer.parseInt(attributes[8]));
                        break;
                    case "PowerUp":
                        effect = new PowerUp(Integer.parseInt(attributes[8]));
                        break;
                    case "Root":
                        effect = new Root(Integer.parseInt(attributes[8]));
                        break;
                    case "Shield":
                        effect = new Shield(Integer.parseInt(attributes[8]));
                        break;
                    case "Shock":
                        effect = new Shock(Integer.parseInt(attributes[8]));
                        break;
                    case "Silence":
                        effect = new Silence(Integer.parseInt(attributes[8]));
                        break;
                    case "Stun":
                        effect = new Stun(Integer.parseInt(attributes[8]));
                        break;
                    default:
                        effect = new SpeedUp(Integer.parseInt(attributes[8]));
                        break;
                }

                availableAbilities.add(new CrowdControlAbility(
                        name,
                        cost,
                        baseCoolDown,
                        castRange,
                        areaOfEffect,
                        requiredActionPoints,
                        effect));
            } else if (attributes[0].equals("DMG")) {
                int damageAmount = Integer.parseInt(attributes[7]);
                availableAbilities.add(new DamagingAbility(
                        name,
                        cost,
                        baseCoolDown,
                        castRange,
                        areaOfEffect,
                        requiredActionPoints,
                        damageAmount));
            } else {
                int healAmount = Integer.parseInt(attributes[7]);
                availableAbilities.add(new HealingAbility(
                        name,
                        cost,
                        baseCoolDown,
                        castRange,
                        areaOfEffect,
                        requiredActionPoints,
                        healAmount));
            }

            line = br.readLine();
        }

        br.close();
    }

    /**
     * Loads all champions from CSV File into local Array
     *
     */
    public static void loadChampions(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine();

        while (line != null) {
            String[] attributes = line.split(",");
            String name = attributes[1];
            int maxHP = Integer.parseInt(attributes[2]);
            int mana = Integer.parseInt(attributes[3]);
            int maxActionPointsPerTurn = Integer.parseInt(attributes[4]);
            int speed = Integer.parseInt(attributes[5]);
            int attackRange = Integer.parseInt(attributes[6]);
            int attackDamage = Integer.parseInt(attributes[7]);
            Champion champion;

            if (attributes[0].equals("A")) {
                champion = new AntiHero(
                        name,
                        maxHP,
                        mana,
                        maxActionPointsPerTurn,
                        speed,
                        attackRange,
                        attackDamage);
            } else if (attributes[0].equals("H")) {
                champion = new Hero(
                        name,
                        maxHP,
                        mana,
                        maxActionPointsPerTurn,
                        speed,
                        attackRange,
                        attackDamage);
            } else {
                champion = new Villain(
                        name,
                        maxHP,
                        mana,
                        maxActionPointsPerTurn,
                        speed,
                        attackRange,
                        attackDamage);
            }

            for (int i = 0; i < availableAbilities.size(); i++) {
                Ability currentAbility = availableAbilities.get(i);
                String currentAbilityName = currentAbility.getName();

                if (currentAbilityName.equals(attributes[8]) ||
                        currentAbilityName.equals(attributes[9]) ||
                        currentAbilityName.equals(attributes[10])) {
                    champion.getAbilities().add(currentAbility);
                }
            }
            availableChampions.add(champion);
            line = br.readLine();
        }
        br.close();
    }

}
