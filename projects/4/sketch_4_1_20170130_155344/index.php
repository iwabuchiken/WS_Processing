<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <title>Processing Demo</title>

	<meta name="viewport"
           content="width=device-width,
			user-scalable=yes,
			initial-scale=1.00,
			minimum-scale=0.01,
                    maximum-scale=3.0" />
  
  <?php 
  
  	$sname = gethostname();
  	
  	if ($sname == "iwabuchiken-PC") {
  	
  		echo "<script src=\"/WS_Processing/projects/4/sketch_4_1_20170130_155344/main.js\" ></script>";
  		
  		echo "<script src=\"/WS_Processing/projects/4/sketch_4_1_20170130_155344/processing.min.js\" ></script>";
  	
  	} else {
  	
  		echo "<script src=\"/WS/WS_Processing_projects/4/sketch_4_1_20170130_155344/main.js\" ></script>"; //=> w. 
  		
  		echo "<script src=\"/WS/WS_Processing_projects/4/sketch_4_1_20170130_155344/processing.min.js\" ></script>"; //=> w. 
//   		echo "<script src=\"WS/WS_Processing_projects/4/sketch_4_1_20170130_155344/main.js\" ></script>"; //=> n.w.
//   		echo "<script src=\"./WS/WS_Processing_projects/4/sketch_4_1_20170130_155344/main.js\" ></script>";
//   		echo "<script src=\"/WS/WS_Processing_projects/4/sketch_4_1_20170130_155344/main.js\" ></script>";
//   		
  		
  	}//if ($sname == "iwabuchiken-PC")
  	
  	
  
  
  ?>
  
  <!-- <script src="/WS_Processing/projects/4/sketch_4_1_20170130_155344/main.js" ></script> -->
  
  <!-- <script src="/WS_Processing/projects/4/sketch_4_1_20170130_155344/processing.min.js" ></script> -->
  
  <!-- <script src="./WS_Processing/projects/4/sketch_4_1_20170130_155344/main.js" /> -->
  
<!-- <script src="./processing.js"></script> -->

</head>
<body>

<hr>

<?php 

// 		echo gethostname();
		
?>

<hr>



yes, yesssss

<?php 

	$sname = gethostname();
	
	$src_pde = "";
	 
	if ($sname == "iwabuchiken-PC") {
		
		$src_pde = "/WS_Processing/projects/4/sketch_4_1_20170130_155344/sketch_4_1_20170130_155344.pde";
		 
	} else {

		$src_pde = "/WS/WS_Processing_projects/4/sketch_4_1_20170130_155344/sketch_4_1_20170130_155344.pde";

	}//if ($sname == "iwabuchiken-PC")

?>

	<canvas data-processing-sources="<?php echo $src_pde;?>"></canvas>

  <!-- <canvas data-processing-sources="/WS_Processing/projects/4/sketch_4_1_20170130_155344/sketch_4_1_20170130_155344.pde"></canvas> -->
  
</body>
</html>
