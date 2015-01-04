/*

   If you have a 2 GB file with one string per line, which sorting algorithm 
   would you use to sort the file and why?

 */
package SortingAndSearching;

/**
 *
 * @author Reza Amini
 */
public class SortLargeFile {
    /*
    
       When an interviewer gives a size limit of 2GB, it should tell you something 
       - in this case, it suggests that they don't want you to bring all the data
       into memory. So what do we do? We only bring part of the data into memory. 
       
       Algorithm:
       
       How much memory do we have available? Let’s assume we have X MB of memory available.
       1. Divide the file into K chunks, where X * K = 2 GB. Bring each chunk into
          memory and sort the lines as usual using any O(n log n) algorithm. 
          Save the lines back to the file.
       2. Now bring the next chunk into memory and sort.
       3. Once we're done, merge them one by one.
       
       The above algorithm is also known as external sort. 
       Step 3 is known as N-way merge.
       The rationale behind using external sort is the size of data. 
       Since the data is too huge and we can't bring it all into memory, 
       we need to go for a disk based sorting algorithm.
       
       In this example, let's say we have 0.5 GB memory available. 
       (1) Read 0.5 GB of the data in main memory and sort by quicksort.
       (2) Write the sorted data to disk.
       (3) Repeat steps 1 and 2 for 4 times until all of the data is in sorted 
           0.5 GB chunks (there are 2GB / 0.5GB = 4 chunks), which now need to be
           merged into one single output file.
       (4) Read the first 0.1 GB (= 0.5GB / (4 chunks + 1)) of each sorted chunk 
           into input buffers in main memory and allocate the remaining 0.1 GB 
           for an output buffer. (In practice, it might provide better performance
           to make the output buffer larger and the input buffers slightly smaller.)
       (5) Perform a 4-way merge and store the result in the output buffer. 
           Whenever the output buffer fills, write it to the final sorted file 
           and empty it. Whenever any of the 4 input buffers empties, fill it 
           with the next 0.1 GB of its associated 0.5 GB sorted chunk until no 
           more data from the chunk is available. This is the key step that makes
           external merge sort work externally -- because the merge algorithm 
           only makes one pass sequentially through each of the chunks, each chunk
           does not have to be loaded completely; rather, sequential parts of the
           chunk can be loaded as needed.
    
     */
}
