import java.util.*;

//document name and content print class
class Document 
{
	private String docName,text;

	public Document(String docName,String text) 
	{
	  this.docName = docName;
	  this.text = text;
	}
	public String getText() 
	{
		return text;
	}
	@Override
	public String toString() 
	{
		 return "Document [docName=" + docName + ", text=" + text + "]";
	}
 }
 
/*  Class arrayQueue input size of queue through array  */
class arrayQueue
{
	Document Queue[];
    int front=-1,rear=-1,size,len;
	public arrayQueue(int n) 
    {
		size = n;
		len = 0;
        Queue = new Document[size];
        front = -1;
        rear = -1;
    }    
	
	/* Function to insert an element to the queue */
    public void enqueue(Document n) 
    {
		//it execute when queue is full
        if (rear == size-1) 
        {
            System.out.println("Queue is Full");
        }
		//it execute when queue is empty
        else if (front==-1 && rear==-1)
        {
			//front and rear at zero position
			front=rear=0;
			//always insert data from rear side and n is element
			Queue[rear]=n;
		}
		//it execute when insert element in next position
		else
		{
			//icrement position until queue is full
			rear++;
            Queue[rear] = n;
		} 
		//when insert element size is increase
		len++;
    }
	
	/*Function to remove front element from the queue */
    public void dequeue() 
    {
        if (front==-1 && rear==-1)
		{
			System.out.println("Queue is Empty");
		}
		//it method execute when front and rear at same position
        else if(front==rear)
        {
			front=rear=-1;
        }
		else
		{
			System.out.println("Deleted Queue is = "+Queue[front]);
			//front increament for next position
			front++;
		}
		//when delete element size is decrease
		len--;
	}
	
	/*  Function to get the size of the queue */
    public int getSize()
    {
        return len ;
    }    
	
	/*  Function to check the front element of the queue */
    Document peek() 
    {
        if (front==-1 && rear==-1)
		{
			System.out.println("Queue is Empty");
		}
		return Queue[front];
        
    }    
	
	/* Function to display the status of the queue */
    public void display()
    {
		System.out.print("\nQueue = ");		//it print queue element
	
        if (front==-1 && rear==-1)
        {
            System.out.print("Queue is Empty\n");
        }
		else
		{	
			//suppose front 0 and rear at 2 pos then it compare until front value greater or equal to rear
			for (int i=front;i<rear+1;i++)		
			System.out.print(Queue[i]+" ");
		}
        System.out.println();        
    }
}

/* Class QueueImplement  */
public class PrintDocument
{
    public static void main(String s[])
    {
			
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("***Printing A Document***\n");
        System.out.println("Enter Size of Queue: ");
        int n = scan.nextInt();
		
        /* creating object of class arrayQueue */
        arrayQueue q = new arrayQueue(n);        
        /* Perform Queue Operations */  
		
		int choice;	
			
        do
		{
            System.out.println("\n\t##Choose 1 to 5##");
            System.out.println("\t1. Insert Document");
            System.out.println("\t2. Delete Document");
            System.out.println("\t3. Display Front Document");
			System.out.println("\t4. Queue size");
			System.out.println("\t5. Exit");
			System.out.println("Enter your Choice: ");
            choice = scan.nextInt();
			
			switch (choice)
            {
				case 1 : 
					System.out.println("Enter File Name: ");
					String name= scan.next();
					System.out.println("Type File Content: ");
					String text = scan.next();
					Document doc = new Document(name,text);
					q.enqueue(doc); 
					break;                      
				case 2 : 
					System.out.println();
					q.dequeue();
					 break;      
				case 3 :
					System.out.println();
                    System.out.println("Front Document = "+q.peek());
					break; 
				case 4 : 
					System.out.println();
					System.out.println("Size = "+ q.getSize());
					break;
				case 5 : 
					System.exit(0);
					break;					
				default : 
					System.out.println("Wrong Entry \n ");
					break;
            }
            /* display Queue */
            q.display();   
		} while (choice !=5);     
			
    }    
}