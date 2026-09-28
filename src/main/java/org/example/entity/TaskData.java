package org.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks,
                    Set<Task> bobsTasks,
                    Set<Task> carolsTasks,
                    Set<Task> unassignedTasks) {

        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name) {

        if (name.equals("ann")) {
            return annsTasks;
        }

        if (name.equals("bob")) {
            return bobsTasks;
        }

        if (name.equals("carol")) {
            return carolsTasks;
        }

        if (name.equals("all")) {
            Set<Task> allTasks = getUnion(annsTasks, bobsTasks);
            allTasks = getUnion(allTasks, carolsTasks);

            return allTasks;
        }

        return null;
    }

    public Set<Task> getUnion(Set<Task> set1, Set<Task> set2) {
        Set<Task> result = new HashSet<>();
        result.addAll(set1);
        result.addAll(set2);
        return result;
    }

    // İki setin ortak elemanlarını bulur
    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    // İlk setten ikinci sette bulunan elemanları çıkarır
    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        Set<Task> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }
}