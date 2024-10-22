public class TreeMultiSet extends MultiSet {

    // TODO add a Tree object as a private instance variable for this class.
    private Tree tree;

    public TreeMultiSet() {
        this.tree = new Tree();
    }
    /**
     * Add the given item to this multiset.
     *
     * @param item the item to add
     */
    @Override
    void add(Integer item) {
        // TODO complete this method
        this.tree.insert(item);
    }

    void remove(Integer item) {
        this.tree.deleteItem(item);
    }

    boolean contains(Integer item) {
        return this.tree.contains(item);
    }

    boolean isEmpty() {
        return this.tree.isEmpty();
    }

    int count(Integer item) {
        return this.tree.count(item);
    }

    int size() {
        return this.tree.length();
    }
    // TODO write the rest of the implementation for this class so that it uses its private Tree
    //      object to provide the MultiSet functionality.
}
