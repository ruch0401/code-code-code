package twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Authentication Token
 */
public class TT_Problem008 {
    public static void main(String[] args) {
        List<List<Integer>> commands = new ArrayList<>();
        List<Integer> command;
        int[][] cmds = {{0, 1, 1}, {0, 2, 2}, {1, 1, 5}, {1, 2, 7}};
        for (int i = 0; i < 4; i++) {
            command = new ArrayList<>();
            command.add(cmds[i][0]);
            command.add(cmds[i][1]);
            command.add(cmds[i][2]);
            commands.add(command);
        }
        int expiryLimit = 4;
        System.out.println(authenticationToken(expiryLimit, commands));
    }

    private static int authenticationToken(int expiryLimit, List<List<Integer>> commands) {
        Map<Integer, Integer> hm = new HashMap<>();
        if (commands == null || commands.size() == 0) {
            return 0;
        }

        for (List<Integer> command : commands) {
            System.out.println(command);
            Integer tokenType = command.get(0);
            Integer tokenId = command.get(1);
            Integer tokenTime = command.get(2);

            if (tokenType == 0) {
                hm.put(tokenId, tokenTime + expiryLimit);
            } else {
                if (hm.containsKey(tokenId)) {
                    System.out.println("Token Time: " + tokenTime);
                    if (tokenTime <= hm.get(tokenId)) {
                        hm.put(tokenId, tokenTime + expiryLimit);
                    } else {
                        hm.remove(tokenId);
                    }
                }
            }
            System.out.println(hm);
        }

        /*
        find the last inputted token time and filter data based on expiry
        Integer lastTime = commands.get(commands.size() - 1).get(2);
        return (int) hm.values().stream().filter(tokenTime ->  tokenTime >= lastTime).count();
        */

        return hm.size();
    }
}
