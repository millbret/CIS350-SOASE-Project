package DatabaseStuff;

/**********************************************************************
 * @authror Omar Tiba, Bret Miller, Robert Saunders
 * @version  Version 1 for Summer 2020
 * date: 7/22/2020
 * class: AliasTreeNode
 * description: Allows the creation of an alias to be assigned to a
 *              tree node instead of being named after the object
 *              toString class in the Ships class.
 *********************************************************************/

import javax.swing.tree.DefaultMutableTreeNode;

public class AliasTreeNode extends DefaultMutableTreeNode {

    /* name for the new Node object */
    private String alias;

    /******************************************************************
     * Constructor that sets a node to a specified user object and a
     * name associate with that object
     * @param userObject Object to be stored in the node
     * @param alias name of the node
     *****************************************************************/
    public AliasTreeNode(Object userObject, String alias){
        super(userObject);
        this.alias = alias;
    }

    /******************************************************************
     * Sets the name of the node with a new alias
     * @param alias name of the new node
     ******************************************************************/
    public void setAlias(String alias){
        this.alias = alias;
    }

    /******************************************************************
     * Returns the name of the alias as long as it's not equal to null
     * @return name of the alias
     *****************************************************************/
    @Override
    public String toString(){
        return (alias != null) ? alias : super.toString();

    }
}

