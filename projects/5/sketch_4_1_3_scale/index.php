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
  
  	$url_processing_local = "/WS_Processing/projects/libs/processing.min.js";
  	$url_main_local = "/WS_Processing/projects/libs/main.js";
  
  	$url_processing_remote = "/WS/WS_Processing_projects/libs/processing.min.js";
  	$url_main_remote = "/WS/WS_Processing_projects/libs/main.js";
  
  	$url_Back_Local = "/WS_Processing/projects/5/";
  	$url_Back_Remote = "/WS/WS_Processing_projects/5/";;

  	$url_Pde_Local = "/WS_Processing/projects/5/sketch_4_1_3_scale/sketch_4_1_3_scale.pde";
  	$url_Pde_Remote = "/WS/WS_Processing_projects/5/sketch_4_1_3_scale/sketch_4_1_3_scale.pde";

  	/*
  	 * include: processing.min.js
  	 * 
  	 */
  
  	$sname = gethostname();
  	
  	if ($sname == "iwabuchiken-PC") {
  	
//   		echo "<script src=\"/WS_Processing/projects/4/sketch_4_1_2_animation/main.js\" ></script>";

  		$url = $url_processing_local;
//   		$url = "/WS_Processing/projects/libs/processing.min.js";
//   		echo "<script src=\"/WS_Processing/projects/4/sketch_4_1_2_animation/processing.min.js\" ></script>";
  	
  		$url_main = $url_main_local;
//   		$url_main = "/WS_Processing/projects/libs/main.js";
  		
  	} else {
  	
//   		echo "<script src=\"/WS/WS_Processing_projects/4/sketch_4_1_2_animation/main.js\" ></script>"; //=> w. 
  		
//   		echo "<script src=\"/WS/WS_Processing_projects/4/sketch_4_1_2_animation/processing.min.js\" ></script>"; //=> w.
  		$url = $url_processing_remote;
//   		$url = "/WS/WS_Processing_projects/libs/processing.min.js";
  		
  		$url_main = $url_main_remote;
//   		$url_main = "/WS/WS_Processing/projects/libs/main.js";
  		
  	}//if ($sname == "iwabuchiken-PC")

  	echo "<script src=\"".$url."\" ></script>"; //=> w.
  	echo "<br>";
  	
  	echo "<script src=\"".$url_main."\" ></script>"; //=> w.
  	
  ?>
  
</head>
<body>

yes, yes

<?php 

	$sname = gethostname();
	
	$url_back = "";
	 
	if ($sname == "iwabuchiken-PC") {
		
		$url_back = $url_Back_Local;
// 		$url_back = "/WS_Processing/projects/5/";
		 
	} else {

		$url_back = $url_Back_Remote;
// 		$url_back = "/WS/WS_Processing_projects/5/";

	}//if ($sname == "iwabuchiken-PC")
		
	
	echo "<a href=\"".$url_back."\">back</a>";

?>


<hr>

<?php 

	$sname = gethostname();
	
	$src_pde = "";
	 
	if ($sname == "iwabuchiken-PC") {
		
		$src_pde = $url_Pde_Local;
// 		$src_pde = "/WS_Processing/projects/5/sketch_4_1_4_scale_2.pde";
		 
	} else {

		$src_pde = $url_Pde_Remote;
// 		$src_pde = "/WS/WS_Processing_projects/5/sketch_4_1_4_scale_2.pde";

	}//if ($sname == "iwabuchiken-PC")

?>

	<canvas data-processing-sources="<?php echo $src_pde;?>"></canvas>

</body>
</html>
