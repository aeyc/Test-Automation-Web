<html>
<body>

<?php

    session_start();
    $connection = mysqli_connect('dijkstra.ug.bcc.bilkent.edu.tr', 'begum.tascioglu', '3Y2HxbNq', 'begum_tascioglu');
    $_SESSION['apply']= "false";
    if(! $connection)
    {
        die('Connection Error!!! ' . mysqli_error());
    }

$_SESSION['acctype']="Invalid";


if (isset($_POST["login"])){
    $sid = $_POST['sid'];
    $password = $_POST['password'];
	if ($_POST['sid']> 19999999 && $_POST['sid']< 199999999 && $_POST["password"]!=""){
		$query="SELECT sid, password FROM User WHERE sid='$sid' AND password = '$password';";

        $result = $connection-> query($query);
        if($result -> num_rows == 1)
        {
            $message = "Successfully logged in";
            echo "<script type='text/javascript'>alert('$message');
        }

        $wrong_password="SELECT sid, password FROM User WHERE sid='$sid' AND password != '$password';";
        $wrong_password_result = $connection-> query($wrong_password);
        if($result -> num_rows == 0 && $wrong_password_result -> num_rows ==1)
        {
            $message = "Wrong Password";
            echo "<script type='text/javascript'>alert('$message');
        }
		else
            $message = "Wrong Password";
            echo "<script type='text/javascript'>alert('$message');
	}
	else if ($_POST['sid']== "")
		$message="ID cannot be empty";
        echo "<script type='text/javascript'>alert('$message');
	else if ($_POST["password"]==""){
		$message="Password required";
        echo "<script type='text/javascript'>alert('$message');
	}
}

if (isset($_POST['register'])){
	$host  = $_SERVER['HTTP_HOST'];
	$uri  = rtrim(dirname($_SERVER['PHP_SELF']), '/\\');
	$extra = 'registercreator.php';
	header("Location: http://$host$uri/$extra");
}

?>

<form action="" method="POST" enctype="multipart/form-data">
<br>
Username: <input type="text" name="sid" value="ID">

<br>
Password: <input type="password" name="password">
<br>
<input type="submit" name="login" value="Sign in">
<input type="submit" name="register" value="Create account">
</form>

</body>
</html>
