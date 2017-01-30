<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <title>Processing Demo</title>

	<meta name="viewport"
           content="width=device-width,
           
			minimum-scale=1.0,
			minimum-scale=0.01,
			
			initial-scale=0.50
			" />
  
  <?php 
  
  	$sname = gethostname();
  	
  	if ($sname == "iwabuchiken-PC") {
  	
//   		echo "<script src=\"/WS_Processing/projects/4/sketch_4_1_2_animation/main.js\" ></script>";
  		
  		echo "<script src=\"/WS_Processing/projects/4/sketch_4_1_2_animation/processing.min.js\" ></script>";
  	
  	} else {
  	
//   		echo "<script src=\"/WS/WS_Processing_projects/4/sketch_4_1_2_animation/main.js\" ></script>"; //=> w. 
  		
  		echo "<script src=\"/WS/WS_Processing_projects/4/sketch_4_1_2_animation/processing.min.js\" ></script>"; //=> w. 
  		
  	}//if ($sname == "iwabuchiken-PC")
  	
  ?>
  
</head>
<body>

<!-- yes, yesssss -->

<?php 

	$sname = gethostname();
	
	$url_back = "";
	 
	if ($sname == "iwabuchiken-PC") {
		
		$url_back = "/WS_Processing/projects/4/";
		 
	} else {

		$url_back = "/WS/WS_Processing_projects/4/";

	}//if ($sname == "iwabuchiken-PC")
		
	
	echo "<a href=\"".$url_back."\">back</a>";

?>


<hr>

<?php 

	$sname = gethostname();
	
	$src_pde = "";
	 
	if ($sname == "iwabuchiken-PC") {
		
		$src_pde = "/WS_Processing/projects/4/sketch_4_1_2_animation/sketch_4_1_2_animation.pde";
		 
	} else {

		$src_pde = "/WS/WS_Processing_projects/4/sketch_4_1_2_animation/sketch_4_1_2_animation.pde";

	}//if ($sname == "iwabuchiken-PC")

?>

	<canvas data-processing-sources="<?php echo $src_pde;?>"></canvas>

</body>
</html>
