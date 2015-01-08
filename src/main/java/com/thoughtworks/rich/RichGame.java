package com.thoughtworks.rich;

import com.thoughtworks.rich.event.EventfulDot;
import com.thoughtworks.rich.io.IO;
import com.thoughtworks.rich.model.Role;
import com.thoughtworks.rich.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

public class RichGame {
    public static final String QUIT_COMMAND = "quit";
    private static final String WORD_COMMAND = "work";
    private static final String NEXT_ROUND = "";
    private Dice dice;
    private RichMap richMap = null;
    private RoleRepository roleRepo = new RoleRepository();

    public RichGame(Dice dice) {
        this.dice = dice;
        richMap = new RichMap();
    }

    public void run() {
        IO io = IO.getInstance();
        io.println(richMap.mapString());

        List<Player> players = getPlayersFromRoles(roleRepo.all(), io);

        runPlayers(io, players);
    }

    private void runPlayers(IO io, List<Player> players) {
        Player player = null;

        while(true) {
            player = nextPlayer(players, player);
            boolean shouldQuitProgram = false;

            String command;
            while ((command = io.nextLine())!=null) {
                if (QUIT_COMMAND.equals(command)) {
                    System.out.println("游戏结束");
                    shouldQuitProgram = true;
                    break;
                }
                if (WORD_COMMAND.equals(command)) {
                    work(player, richMap);
                }
                if (NEXT_ROUND.equals(command)) {
                    break;
                }
                io.println(richMap.mapString());
            }

            if( command == null) {
                break;
            }

            if(shouldQuitProgram) {
                break;
            }
        }
    }

    private Player nextPlayer(List<Player> players, Player player) {
        if(player == null) {
            return players.get(0);
        } else {
            int index = players.indexOf(player);
            return players.get((index + 1) % players.size());
        }
    }

    private List<Player> getPlayersFromRoles(List<Role> allRoles, IO io) {
        io.println("请选择玩家"+ allRoles +"\n");
        String selectedRoles = io.nextLine();
        List<Player> players = new ArrayList<Player>();
        if(!"".equals(selectedRoles)) {
            for(int i = 0;i < selectedRoles.length();i++) {
                Role role = roleRepo.findBySymbol(selectedRoles.charAt(i));
                if(role != null) {
                    players.add(role.createPlayer(1000, richMap.startingDot()));
                }
            }
        }
        return players;
    }

    private void work(Player player, RichMap richMap) {
        int steps = dice.roll();
        EventfulDot eventfulDot = richMap.getEventfulDotAfter(player.locatingDot, steps);
        player.moveTo(eventfulDot.getDot());
        eventfulDot.handleEvent(player);
    }

    public static void main(String[] args) {
        new RichGame(new Dice(6)).run();
    }
}
