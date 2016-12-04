# mxGraph-anchor-points
Create a mxGraph sample application to understand how it computes anchor points for connecting mxCell and albow points (or just another mxCell with some code changes).

Directly working on mxGraph source code rather than adding jar for easiler debugging.

Basically all the magic things happen in mxPerimeterFunction RectanglePerimeter (called by mxGraphView.updateFloatingTerminalPoints) for my case.

### Run and build
Run java application sample.mxGraphSample
