import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Integer count(Integer item){
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

    private List<Tree> getSubtrees() {
        return this.subtrees;
    }

    private Integer getRoot() {
        return this.root;
    }

}
