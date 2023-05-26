public class PowerSet {
  private java.util.ArrayList<String> data;

  public PowerSet() {
    data = new java.util.ArrayList<String>(20_000);
  }

  public int size() {
    return data.size();
  }

  public void put(String value) {
    for (String x : data)
      if (x.equals(value))
        return;
    data.add(value);
  }

  public boolean get(String value) {
    for (String x : data)
      if (x.equals(value))
        return true;
    return false;
  }

  public boolean remove(String value) {
    return data.remove(value);
  }

  public PowerSet intersection(PowerSet set2) {
    PowerSet intersection = new PowerSet();
    for (String x : data)
      if (set2.get(x))
        intersection.put(x);
    return intersection;
  }

  public PowerSet union(PowerSet set2) {
    PowerSet union = new PowerSet();
    for (String x : data)
      union.put(x);
    for (String x : set2.data)
      union.put(x);
    return union;
  }

  public PowerSet difference(PowerSet set2) {
    PowerSet diff = new PowerSet();
    for (String x : data)
      diff.put(x);
    for (String x : set2.data)
      diff.remove(x);
    return diff;
  }

  public boolean isSubset(PowerSet set2) {
    if (set2.difference(this).size() == 0)
      return true;
    return false;
  }
}
