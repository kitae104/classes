package inhatc.cse.java.quiz.b;

public class Ex3Answer {

    record Pair<K, V>(K key, V value) {
    }

    public static <K, V> Pair<V, K> swap(Pair<K, V> pair) {
        return new Pair<>(pair.value(), pair.key());
    }

    public static void main(String[] args) {
        Pair<Integer, String> original = new Pair<>(1, "One");
        Pair<String, Integer> swapped = swap(original);

        System.out.println("original=" + original);
        System.out.println("swapped=" + swapped);
    }
}
