# Object Detection with DBScan Algorithm - General Description

This project involves the implementation of the DBScan algorithm for object detection in a scene captured by a LiDAR (laser scanner). The main objective is to improve the efficiency of the algorithm by utilizing a k-d tree data structure for faster neighborhood search.

The DBScan algorithm, implemented in the project's codebase, is used to detect clusters of points representing objects in the captured scene. However, the algorithm's runtime complexity can become inefficient for large datasets, as it requires searching each point's neighborhood, resulting in a complexity of O(N^2) in the worst case.

To address this inefficiency, the project introduces a new `NearestNeighborsKD` class, which implements the k-d tree data structure. The k-d tree partitions the point cloud data into a binary tree representation, enabling faster search operations with a complexity of O(log N) for finding neighbors of a given point.

The main tasks in the project include:
- Building the k-d tree from the 3D point cloud data obtained from LiDAR scans.
- Implementing the range query method in the `NearestNeighborsKD` class to efficiently find nearest neighbors using the k-d tree.
  
By employing the k-d tree data structure, the project aims to significantly improve the runtime complexity of the DBScan algorithm, leading to faster and more efficient object detection in LiDAR-captured scenes.
