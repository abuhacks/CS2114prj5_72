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
        firstNode = null;
        firstNode.next = lastNode;
        lastNode = null;
        lastNode.prev = firstNode;
        size = 0;
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
        if (firstNode == null)
        {
            firstNode = toAdd;
            lastNode = toAdd;
        }
        else
        {
            lastNode.next = toAdd;
            toAdd = lastNode;
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
     */
    @Override
    public void add(int index, T entry)
    {

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
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public T getEntry(int index)
    {
        int current = 0;
        Node<T> entry = firstNode;
        if (size > 0 && index < size && index > 0)
        {
            while (current < index)
            {
                entry = entry.getNext();
                current++;
            }
            return entry.getData();
        }
        throw new IndexOutOfBoundsException();
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
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(int entry)
    {
        // TODO Auto-generated method stub
        return null;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public T replace(int index, T entry)
    {
        // TODO Auto-generated method stub
        return null;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray()
    {
        // TODO Auto-generated method stub
        return null;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    public String toString()
    {

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
    public boolean equals(Object object)
    {

    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(T o)
    {
        // TODO Auto-generated method stub
        return 0;
    }

}
