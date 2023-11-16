package prj5;

import list.ListInterface;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author jchen
 * @version Nov 14, 2023
 */
public class DoublyLinkedList<T>
    implements ListInterface<T>, Comparable<T>
{
    private static class Node<T>
    {
        // ~ Fields ............................................................
        private T data;
        private Node<T> next;
        private Node<T> prev;

        // ~ Constructors ......................................................
        // ----------------------------------------------------------
        /**
         * Create a new Node object.
         * 
         * @param data
         *            the data a Node object will hold
         */
        public Node(T data)
        {
            this.data = data;
        }


        // ----------------------------------------------------------
        /**
         * Create a new Node object.
         * 
         * @param data
         *            the data an object holds
         * @param next
         *            the next Node of this Node object
         * @param prev
         *            the previous Node of this Node object
         */
        public Node(T data, Node<T> next, Node<T> prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }


        // ~Public Methods .....................................................
        // ----------------------------------------------------------
        /**
         * This is a setter method for the next Node of the current Node.
         * 
         * @param nextNode
         *            the node the next Node will be set to
         */
        public void setNext(Node<T> nextNode)
        {
            next = nextNode;
        }


        // ----------------------------------------------------------
        /**
         * This is the getter method for the next Node of the current Node.
         * 
         * @return next, the next Node of the current Node
         */
        public Node<T> getNext()
        {
            return next;
        }


        // ----------------------------------------------------------
        /**
         * This is a setter method for the previous Node of the current Node.
         * 
         * @param prevNode
         *            the node the previous node will be set to
         */
        public void setPrevious(Node<T> prevNode)
        {
            prev = prevNode;
        }


        // ----------------------------------------------------------
        /**
         * This is the getter method for the previous Node of the current Node.
         * 
         * @return prev, the previous Node of the current Node
         */
        public Node<T> getPrevious()
        {
            return prev;
        }


        // ----------------------------------------------------------
        /**
         * This is the getter method for the data of a Node Object.
         * 
         * @return data the information contained by the current Node
         */
        public T getData()
        {
            return data;
        }
    }

    // ~ Fields ................................................................
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new DoublyLinkedList object.
     */

    public DoublyLinkedList()
    {
        firstNode = new Node<T>(null);
        lastNode = new Node<T>(null);
        firstNode.next = lastNode;
        lastNode.prev = firstNode;
        size = 0;
    }


    // ~Private Methods ........................................................
    // ----------------------------------------------------------
    /**
     * This is a private helper method that gets the node at a specified index.
     * 
     * @param index
     *            the index in a DoublyLinkedList where a Node will be located
     * @return Node at specified index
     * @throw IndexOutOfBoundsException if size is greater than 0, index is
     *            greater than size, or index is less than 0.
     */
    private Node<T> getNode(int index)
    {
        int current = 0;
        Node<T> entry = firstNode;
        if (size > 0 && index < size && index >= 0)
        {
            while (current < index)
            {
                entry = entry.getNext();
                current++;
            }
            return entry;
        }
        throw new IndexOutOfBoundsException();
    }
    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * This method adds a new entry to the end of the list.
     * 
     * @param entry
     *            the data of the node being added to the end of the list
     */
    @Override
    public void add(T entry)
    {
        Node<T> toAdd = new Node<T>(entry);
        if (isEmpty())
        {
            firstNode = toAdd;
            lastNode = toAdd;
        }
        else
        {
            lastNode.setNext(toAdd);
            toAdd.setPrevious(lastNode);
            lastNode = toAdd;
        }
        size++;
    }


    // ----------------------------------------------------------
    /**
     * This method adds a new entry at the index specified by the int parameter.
     * 
     * @param index
     *            the index a new entry will be added to a list
     * @param entry
     *            the data of the node being added to a list
     * @throws IndexOutOfBoundsException
     *             when index is below 0 or above the current size of the
     *             DoublyLinkedList
     */
    @Override
    public void add(int index, T entry)
    {
        if ((index == 0) || (index == size - 1))
        {
            this.add(entry);
            size++;
        }
        else
        {
            Node<T> nextEntry = getNode(index);
            size++;
        }

        
        throw new IndexOutOfBoundsException();
    }


    // ----------------------------------------------------------
    /**
     * This method clears a DoublyLinkedList object and removes all entries.
     */
    @Override
    public void clear()
    {
        firstNode = null;
        firstNode.next = lastNode;
        lastNode = null;
        lastNode.prev = firstNode;
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * This method checks if an object is stored in the DoublyLinkedList.
     * 
     * @return true if the list contains the entry/object, false otherwise.
     */
    @Override
    public boolean contains(T entry)
    {
        Node<T> current = firstNode;
        while (current != null)
        {
            if (current.getData().equals(entry))
            {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * This method gets the Node's data for a specificed index.
     * 
     * @return Object stored in a specific Node, which is determined through the
     *             index parameter.
     */
    @Override
    public T getEntry(int index)
    {
        return getNode(index).getData();
    }


    // ----------------------------------------------------------
    /**
     * This method returns the length of a DoublyLinkedList.
     */
    @Override
    public int getLength()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * This method checks if a DoublyLinkedList is empty or not.
     * 
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }


    // ----------------------------------------------------------
    /**
     * This method removes a Node at a specified index.
     * 
     * @return the data of the Node being removed, or IndexOutOfBoundsException
     * @param index
     *            the location of the Node being removed
     * @throws IndexOutOfBoundsException
     *             when the list is empty or index is greater than the length of
     *             list.
     */
    @Override
    public T remove(int index)
    {
        Node<T> placeholder = getNode(index);
        if (!this.isEmpty() && index < this.getLength())
        {
            placeholder.getPrevious().setNext(placeholder.getNext());
            placeholder.getNext().setPrevious(placeholder.getPrevious());
            size--;
            return placeholder.getData();
        }
        throw new IndexOutOfBoundsException();

    }


    // ----------------------------------------------------------
    /**
     * This method replaces a Node with a different Node that stores a different
     * object.
     * 
     * @return the object that will be replaced by the entry in the parameter.
     */
    @Override
    public T replace(int index, T entry)
    {
        Node<T> placeholder = getNode(index);
        Node<T> replacement = new Node<T>(entry);
        placeholder.getPrevious().setNext(replacement);
        placeholder.getNext().setPrevious(replacement);
        return placeholder.getData();
    }


    // ----------------------------------------------------------
    /**
     * This method turns a DoublyLinkedList into an array.
     * 
     * @return an array that holds all entries in a DoublyLinked List
     */
    @Override
    public Object[] toArray()
    {
        Object[] entries = new Object[getLength()];
        Node<T> current = firstNode;
        for (int i = 0; i < this.getLength(); i++)
        {
            entries[i] = current.getData();
            current = current.getNext();
        }
        return entries;
    }


    // ----------------------------------------------------------
    /**
     * This method returns the string representation of a DoublyLinkedList.
     * 
     * @return String representation of DoublyLinkedList
     */
    public String toString()
    {
        StringBuilder entries = new StringBuilder();
        entries.append("{");
        Node<T> current = firstNode;
        while (current != null)
        {
            entries.append(current.getData());
            if (current != lastNode)
            {
                entries.append(", ");
            }
            current = current.getNext();
        }
        entries.append("}");
        return entries.toString();
    }


    // ----------------------------------------------------------
    /**
     * This method checks if two DoublyLinkedList have the same contents in the
     * same order.
     * 
     * @return true if same contents same order, false otherwise
     * @param object
     *            the object the current DoublyLinkedList is being compared to
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object object)
    {
        if (this.getClass() == object.getClass() && object != null)
        {
            DoublyLinkedList<T> obj = (DoublyLinkedList<T>)object;
            if (this.getLength() == obj.getLength())
            {
                Node<T> thisCurrent = this.firstNode;
                Node<T> objectCurrent = obj.firstNode;
                while (thisCurrent != null)
                {
                    if (!thisCurrent.getData().equals(objectCurrent.getData()))
                    {
                        return false;
                    }
                    thisCurrent = thisCurrent.getNext();
                    objectCurrent = objectCurrent.getNext();
                }
                return true;
            }
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * This method compares two DoublyLinkedLists and it will rank a
     * DoublyLinkedList higher or lower based on size.
     */
    @Override
    public int compareTo(T obj)
    {
        // TODO Auto-generated method stub
        return 0;
    }

}
