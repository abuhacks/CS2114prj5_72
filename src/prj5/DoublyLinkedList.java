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

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

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


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public void add(T arg0)
    {
        // TODO Auto-generated method stub

    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public void add(int arg0, T arg1)
    {
        // TODO Auto-generated method stub

    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public void clear()
    {
        // TODO Auto-generated method stub

    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(T arg0)
    {
        // TODO Auto-generated method stub
        return false;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public T getEntry(int arg0)
    {
        // TODO Auto-generated method stub
        return null;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public int getLength()
    {
        // TODO Auto-generated method stub
        return 0;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty()
    {
        // TODO Auto-generated method stub
        return false;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(int arg0)
    {
        // TODO Auto-generated method stub
        return null;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public T replace(int arg0, T arg1)
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

}
