import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test
{

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, x, y, k;
        int[] paths;
        List[] l;


        // get n and initialize paths and lists
        n = Integer.parseInt(br.readLine());
        paths = new int [n + 1];
        l = new List [n + 1];
        for (int i = 1 ; i <= n ; i++)
        {
            paths [i] = 0;
            l [i] = new List ();
        }
        String S = br.readLine();
        int X = 0, Y = 0;
        while(!S.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(S);
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            l[Y].add(X);
            S = br.readLine();
        }
        l[Y].add(X);
        // deal with the paths from point n
        while (!l [n].empty ())
            paths [l [n].remove ()] = 1;

        // process all the other paths, working upwards
        for (int i = n - 1 ; i >= 1 ; i--)
        {
            while (!l [i].empty ())
            {
                k = l [i].remove ();
                paths [k] = paths [i] + paths [k];
            }
        }

        // print answer found in paths[1]
        System.out.println(paths [1]);
    }
}

// Node class used by the List class
class Node
{
    public int p;
    public Node next;

    public Node (int x)
    {
        p = x;
        next = null;
    }
}

// A simple singly linked, linear list. 
// Nodes are added to front of list only.
class List
{
    Node l;

    public List ()
    {
        l = null;
    }


    public boolean empty ()
    {
        return l == null;
    }


    public void add (int x)
    {
        Node n = new Node (x);
        n.next = l;
        l = n;
    }


    public int remove ()
    {
        int x = l.p;
        l = l.next;
        return x;
    }
}