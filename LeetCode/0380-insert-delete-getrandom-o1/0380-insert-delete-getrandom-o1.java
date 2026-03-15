import java.util.*;
class RandomizedSet {

    private Random random;
    private Map<Integer, Integer> map;
    private List<Integer> keys;

    public RandomizedSet() {
        map = new HashMap<>();
        keys = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
		if (map.putIfAbsent(val, keys.size()) == null) {
		    keys.add(val);
		    return true;
		}
		return false;
	}
    
    public boolean remove(int val) {
        Integer idx = map.get(val);
        if (idx == null) return false;

        int v = keys.get(keys.size() - 1);
        keys.set(idx, v);
        map.put(v, idx);

        keys.remove(keys.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int idx = random.nextInt(keys.size());
        return keys.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */