import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Tree {
    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py
    private Integer root;
    private List<Tree> subtrees;

    public Tree(Integer root, List<Tree> subtrees){
        this.root = root;
        if (this.root == null){
            this.subtrees = new ArrayList<>();
        }
        else{
            this.subtrees = subtrees;
        }
    }

    public Tree(){
        this(null, null);
    }

    public Boolean isEmpty(){
        return this.root == null;
    }

    public Integer length(){
        if (this.isEmpty()){
            return 0;
        }
        else {
            Integer currentSize = 1;
            for (Tree subtree : this.subtrees){
                currentSize += subtree.length();
            }
            return currentSize;
        }
    }

    public int count(Integer item){
        if (this.isEmpty()){
            return 0;
        }
        else {
            Integer currentCount = 0;
            if (this.root.equals(item)){
                currentCount++;
            }
            for (Tree subtree : this.subtrees){
                currentCount += subtree.count(item);
            }
            return currentCount;
        }
    }

    public String stringRepresentation(){
        return this.indentedStringRepresentation();
    }

    public String indentedStringRepresentation(){
        return this.indentedStringRepresentation(0);
    }

    public String indentedStringRepresentation(Integer Depth){
        if (this.isEmpty()){
            return "";
        }
        else {
            String tempString = "";
            for (int i = 0; i < Depth; i++) {
                tempString += " ";
            }
            tempString += this.root.toString() + "\n";
            for (Tree subtree : this.subtrees){
                tempString += subtree.indentedStringRepresentation(Depth + 1);
            }
            return tempString;
        }
    }

    public Integer average(){
        if (this.isEmpty()){
            return 0;
        }
        else {
            Integer total = this.averageHelper();
            return total / this.subtrees.size();
        }
    }

    public Integer averageHelper(){
        if (this.isEmpty()) {
            return 0;
        }
        else {
            Integer total = this.root;
            for (Tree subtree : this.subtrees){
                total += subtree.averageHelper();
            }
            return total;
        }
    }

    public boolean equals(Tree tree) {
        if (this.isEmpty() && tree.isEmpty()) {
            return true;
        }
        else if (this.isEmpty() || tree.isEmpty()) {
            return false;
        }
        else {
            if (!this.root.equals(tree.getRoot())) {
                return false;
            }
            if (!this.length().equals(tree.length())) {
                return false;
            }
            return this.subtrees.equals(tree.getSubtrees());
        }
    }

    public List<Tree> getSubtrees() {
        return this.subtrees;
    }

    public Integer getRoot() {
        return this.root;
    }

    public boolean contains(Integer item) {
        if (this.isEmpty()) {
            return false;
        }
        else if (this.root.equals(item)) {
            return true;
        }
        else {
            for (Tree subtree : this.subtrees) {
                if (subtree.contains(item)) {
                    return true;
                }
            }
            return false;
        }
    }

    public List<Integer> leaves() {
        List<Integer> result = new ArrayList<>();
        if (!this.isEmpty()) {
            if (this.subtrees.size() == 0) {
                result.add(this.root);
            }
            else {
                for (Tree subtree : this.subtrees) {
                    List<Integer> tempResult = subtree.leaves();
                    result.addAll(tempResult);
                }
            }
        }
        return result;
    }

    public boolean deleteItem(Integer item) {
        if (this.isEmpty()) {
            return false;
        }
        else if (this.root.equals(item)) {
            this.deleteRoot();
            return true;
        }
        else {
            for (Tree subtree : this.subtrees) {
                boolean deleted = subtree.deleteItem(item);
                if (deleted && subtree.isEmpty()) {
                    this.subtrees.remove(subtree);
                    return true;
                }
                else if (deleted) {
                    return true;
                }
            }
            return false;
        }
    }

    private void deleteRoot() {
        if (this.subtrees.isEmpty()) {
            this.root = null;
        }
        else {
            Integer leaf = this.extractLeaf();
            this.root = leaf;
        }
    }

    private Integer extractLeaf() {
        if (this.subtrees.isEmpty()) {
            Integer oldRoot = this.root;
            this.root = null;
            return oldRoot;
        }
        else {
            Integer leaf = this.subtrees.get(0).extractLeaf();
            if (this.subtrees.get(0).isEmpty()) {
                this.subtrees.remove(0);
            }
            return leaf;
        }
    }

    public void insert(Integer item) {
        if (this.isEmpty()) {
            this.root = item;
        }
        else if (this.subtrees.isEmpty()) {
            this.subtrees.add(new Tree(item, new ArrayList<>()));
        }
        else {
            Random rand = new Random();
            int r = rand.nextInt(3);
            if ((r+1) == 3) {
                this.subtrees.add(new Tree(item, new ArrayList<>()));
            }
            if ((r+1) < 3) {
                int m = rand.nextInt(this.subtrees.size());
                this.subtrees.get(m).insert(item);
            }
        }
    }

    public boolean insertChild(Integer item, Integer parent) {
        if (this.isEmpty()) {
            return false;
        }
        else if (this.root.equals(parent)) {
            this.subtrees.add(new Tree(item, new ArrayList<>()));
            return true;
        }
        else {
            for (Tree subtree : this.subtrees) {
                if (subtree.insertChild(item, parent)) {
                    return true;
                }
            }
            return false;
        }
    }
}
