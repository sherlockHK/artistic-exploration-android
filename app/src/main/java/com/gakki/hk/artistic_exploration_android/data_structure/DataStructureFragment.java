package com.gakki.hk.artistic_exploration_android.data_structure;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gakki.hk.artistic_exploration_android.R;

/**
 *
 */
public class DataStructureFragment extends Fragment {


    private TextView console;

    public static DataStructureFragment newInstance() {
        return new DataStructureFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_data_structure, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button linked = (Button) view.findViewById(R.id.btn_linked_list);
        Button stack_and_queue = (Button) view.findViewById(R.id.stack_and_queue);
        Button tree = (Button) view.findViewById(R.id.tree);
        Button graph = (Button) view.findViewById(R.id.graph);
        Button btn_clear = (Button) view.findViewById(R.id.btn_clear);
        console = (TextView) view.findViewById(R.id.tv_console);

        linked.setOnClickListener(v -> linkedTest());
        stack_and_queue.setOnClickListener(v -> stackAndQueueTest());
        tree.setOnClickListener(v -> treeTest());
        graph.setOnClickListener(v -> graphTest());
        btn_clear.setOnClickListener(v -> clearLog());
    }

    private void log(String text) {
        console.setText(console.getText() + "\n" + text);
    }

    private void clearLog() {
        console.setText("");
    }

    private void linkedTest() {
        LinkedList.Node node = LinkedList.generateNode(10);

        //读取
        LinkedList.Node first = LinkedList.get(node, 0);
        LinkedList.Node last = LinkedList.get(node, 9);
        log("linkedTest" + " first: " + first.data + " last: " + last.data);

        //插入和删除
        LinkedList.insert(node, 5, 101);
        LinkedList.Node insertedNode = LinkedList.get(node, 5);
        log("linkedTest" + " insert: " + insertedNode.data);

        LinkedList.delete(node, 1);
        LinkedList.Node deleted = LinkedList.get(node, 1);
        log("linkedTest" + " first: " + deleted.data);
    }

    private void stackAndQueueTest() {
        //入栈
        StackAndQueue.Stack stack = new StackAndQueue.Stack();
        stack.push(2);
        stack.push(3);
        log(" stack push: " + " first: " + stack.first.data + "length: " + stack.length);

        //出栈
        int popData = 0;
        try {
            popData = stack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log(" stack pop: " + popData + "length: " + stack.length);

        //入队列
        StackAndQueue.Queue queue = new StackAndQueue.Queue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        log("enqueue: " + " rear: " + queue.rear.data + " length: " + queue.length);

        //出队列
        int dequeue = queue.dequeue();
        log("enqueue: " + " dequeue: " + dequeue + " front: " + queue.front.data + " length: " + queue.length);
    }

    private void treeTest() {
        TreeStructure.BinaryTree binaryTree = new TreeStructure.BinaryTree();
        binaryTree.generateBinaryTree();

        //前、中、后序遍历
        TreeStructure.BinaryTree.preOrderTraverse(binaryTree.root);
        TreeStructure.BinaryTree.inOrderTraverse(binaryTree.root);
        TreeStructure.BinaryTree.postOrderTraverse(binaryTree.root);
    }

    private void graphTest() {

    }
}
