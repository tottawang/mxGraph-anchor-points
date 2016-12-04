package mxGraphSample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxPoint;
import com.mxgraph.view.mxEdgeStyle;
import com.mxgraph.view.mxGraph;

public class Layout extends JFrame
{
	private static final long serialVersionUID = -578683911307318455L;
	private GraphControl graphControl;

	public Layout()
	{
		super("mxGraph");

		// Creates graph with model
		mxGraph graph = new mxGraph();	
		
		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		
		try
		{			
			// edgeStyle=elbowEdgeStyle works like orthogonal
			// entryX=0;entryY=0; changes connection point to higher vertex
			
			Object object1 = graph.insertVertex(parent, "state1", "state1", 0, 0, 200, 100);
			Object object2 = graph.insertVertex(parent, "state2", "state2", 400, 300, 200, 100);
			//Object object2 = graph.insertVertex(parent, "state2", "state2", 300, 80, 200, 100);
			mxCell cell = (mxCell)graph.insertEdge(parent, null, "transition1", object1, object2, 
					"edgeStyle=noEdgeStyle;elbow=horizontal;orthogonal=1;"
					+ "entryPerimeter=1;");
			cell.toString();
			List<mxPoint> points = new ArrayList<mxPoint>();
			points.add(new mxPoint(300, 600));
			cell.getGeometry().setPoints(points);
		}	
		finally
		{
			graph.getModel().endUpdate();
		}

		graph.getView().setScale(1);
		// Creates a control in a scrollpane
		graphControl = new GraphControl(graph);
		JScrollPane scrollPane = new JScrollPane(graphControl);
		scrollPane.setAutoscrolls(true);

		// Puts the control into the frame
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		setSize(new Dimension(320, 200));
	}

	public static void main(String[] args)
	{
		Layout frame = new Layout();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}