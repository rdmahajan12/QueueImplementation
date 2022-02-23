import java.util.*;
class Document 
{
	private String docName;
	private float size;
	private String text;

	public Document(String docName,float size,String text) 
	{
	  this.docName = docName;
	  this.size = size;
	  this.text = text;
	}


	public float getSize() 
	{
		return size;
	}
	public String getText() 
	{
		return text;
	}
	@Override
	public String toString() 
	{
		 return "Document [docName=" + docName + ", size=" + size +
		", text=" + text + "]";
	}
 }
class Queue 
{
	int front,rear,size;
	int capacity;
	 Document arr[];

	public Queue(int capacity)
	 {
		 this.capacity=capacity;
		 front=this.size=0;
		 rear=capacity-1;
		 arr=new Document[this.capacity];
	 }

	boolean isFull()
	{
		return(this.size==this.capacity);
	}
 
	boolean isEmpty()
	{
		return (this.size == 0);
	}

	void enqueue(Document doc)
	{
		if(isFull())
		{
			return;
		}
		else
		 {
			 this.rear=(this.rear+1)%this.capacity;
			 this.arr[this.rear]=doc;
			 this.size=this.size+1;
			 System.out.println(" insert document to queue "+doc);
		 }
	}

	 Document dequue()
	 {
		if(isEmpty())
		 {
			return null;
		 }
		 else
		 {
			 Document doc=this.arr[this.front];
			 this.front=(this.front+1)%this.capacity;
			 this.size=this.size-1;
			 return doc;
		 }
	 }

	 Document getfrontEle()
	 {
		if(isEmpty())
		 {
			return null;
		 }
		 else
		 {
			return this.arr[this.front];
		 }
	 } 

	 Document getrearEle()
	 {
		 if (isEmpty()) 
		 {
			return null;
		}
		else
		{
			return this.arr[this.rear];
		}
	 }

	 public void print()
	 {
		 if (isEmpty()) 
		 {
			System.out.println("array in empty");
		 }
		 else
		 {
			 for(int i=front;i!=rear;i=(i+1)%capacity) 
			 {
			 System.out.println(arr[i]);
			}
			System.out.println(arr[rear]);
		 }
	 }
 }

public class DocumentTest 
{
	 public static void main(String[] args) 
	 {
	 DocumentTest doct = new DocumentTest();
	 Queue que = new Queue(1000);

	 Scanner sc = new Scanner(System.in); 
	 Scanner sc1 = new Scanner(System.in);

	 boolean flag=true;
	 while(flag)
	 {
	 System.out.println("");
	 System.out.println("select option ");
	 System.out.println("1.request for print(equeue)");
	 System.out.println("2.remove document(dequeue)");
	 System.out.println("3.print inside queue document ");
	 System.out.println("4.exit");

	 int choice = sc.nextInt();

	 switch(choice)
	 {
	 case 1:
	 System.out.println("Enter file name ");
	 String name= sc1.nextLine();
	 System.out.println("Enter file size ");
	 float size =sc.nextFloat();
	 System.out.println("Enter file content ");
	 String text = sc1.nextLine();
	 Document doc = new Document(name,size,text);
	 que.enqueue(doc); 

	 break;

	 case 2:
	 Document result=que.dequue();
	 System.out.println("Document print : "+result);
	 break;

	 case 3:
	 que.print();
	 break;

	 case 4:
	 flag=false;
	 break;

	 default :
	 System.out.println("Invalid choice");
	 }

	}
	}
} 