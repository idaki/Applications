package com.ocadogroup;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Map<String, Set<String>> inputTokensMap = readInput();
        Map<String, Set<String>> outputTokensMap = buildDependenciesMap(inputTokensMap);
        printDependencies(outputTokensMap);

        System.out.println("\n==OPTIONAL Inverse Dependencies ==");
        Map<String, Set<String>> inverseMap = buildInverseDependencyMap(inputTokensMap);
        Map<String, Set<String>> inverseDepsMap = buildDependenciesMap(inverseMap);
        printDependencies(inverseDepsMap);

    }

    private static Map<String, Set<String>> readInput() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> tokensMap = new LinkedHashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;

            String[] tokens = line.split("\\s+");
            String item = tokens[0];
            tokensMap.putIfAbsent(item, new LinkedHashSet<>());

            for (int i = 1; i < tokens.length; i++) {
                tokensMap.get(item).add(tokens[i]);
            }
        }
        scanner.close();
        return tokensMap;
    }

    private static Map<String, Set<String>> buildDependenciesMap(Map<String, Set<String>> inputTokensMap) {
        Map<String, Set<String>> allDeps = new LinkedHashMap<>();

        for (String token : inputTokensMap.keySet()) {
            Set<String> checkedTokens = new LinkedHashSet<>();
            checkedTokens.add(token);
            Set<String> dependencies = findDependencies(token, inputTokensMap, checkedTokens);
            allDeps.put(token, dependencies);
        }

        return allDeps;
    }

    private static Set<String> findDependencies(String token, Map<String, Set<String>> inputTokensMap, Set<String> checkedTokens ) {
        Set<String> result = new LinkedHashSet<>();
        Set<String> direct = inputTokensMap.get(token);
        if (direct == null) {
            return result;
        }

        for (String t : direct) {
            if (!checkedTokens.contains(t)) {
                checkedTokens.add(t);
                result.add(t);
                result.addAll(findDependencies(t, inputTokensMap, checkedTokens ));
            }
        }
        return result;
    }

    private static Map<String, Set<String>> buildInverseDependencyMap(Map<String, Set<String>> inputMap) {
        Map<String, Set<String>> inverseMap = new HashMap<>();

        for (Map.Entry<String, Set<String>> entry : inputMap.entrySet()) {
            String from = entry.getKey();
            for (String to : entry.getValue()) {
                inverseMap.computeIfAbsent(to, k -> new HashSet<>()).add(from);
            }
        }

        return inverseMap;
    }

    private static void printDependencies(Map<String, Set<String>> outpuTokenstMap) {
        for (Map.Entry<String, Set<String>> entry : outpuTokenstMap.entrySet()) {
            String item = entry.getKey();
            List<String> sortedOutputTokens = new ArrayList<>(entry.getValue());
            Collections.sort(sortedOutputTokens);

            System.out.print(item);
            for (String dep : sortedOutputTokens) {
                System.out.print(" " + dep);
            }
            System.out.println();
        }
    }
}

