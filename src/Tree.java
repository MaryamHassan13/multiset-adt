import java.util.ArrayList;
import java.util.List;

public class Tree {
    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py
    private static Integer root;
    private static List<Tree> subtrees;

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

}
