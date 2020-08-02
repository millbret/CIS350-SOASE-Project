package DatabaseStuff;
/******************************************************************************************
 * @author :    Bret Miller, Omar Tiba, Robert Saunders
 * @version :   Version 1 for Summer 2020
 * date:        8/1/2020
 * class:       CheckListItem
 * description: Manages the CheckListItems used for updating the JTable
 ******************************************************************************************/
public class CheckListItem {
    /** Name of the CheckListItem */
    private String label;

    /** Is the CheckListItem selected at start. Default is false */
    private boolean isSelected = false;

    /******************************************************************
     * Constructor
     * @param label name of CheckListItem
     *****************************************************************/
    public CheckListItem(String label) {
        this.label = label;
    }

    /******************************************************************
     * Sets the selected state of the CheckListItem
     * @return whether the CheckListItem is selected or not.
     *         True if selected and false if unselected
     *****************************************************************/
    public boolean isSelected() {
        return isSelected;
    }

    /******************************************************************
     * Sets the CheckListItem to either selected or unselected
     * @param isSelected sets the CheckListItem to a selected state.
     *                   If true it is selected. If false it is
     *                   unselected
     *****************************************************************/
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    /*******************************************************************
     * Returns the label of the CheckListItem
     * @return name of the CheckListItem
     *****************************************************************/
    @Override
    public String toString() {
        return label;
    }
}
