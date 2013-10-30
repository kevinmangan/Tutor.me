<?php

/*
* Title                   : Booking Calendar PRO (jQuery Plugin)
* Version                 : 1.2
* File                    : opendb.php
* File Version            : 1.0
* Created / Last Modified : 20 May 2013
* Author                  : Dot on Paper
* Copyright               : © 2011 Dot on Paper
* Website                 : http://www.dotonpaper.net
* Description             : Connect & create a database.
*/

    define('DB_HOST', 'localhost'); // Enter database host.
    define('DB_USER', 'root'); // Enter database user.
    define('DB_PASS', 'tutorme'); // Enter database password.
    define('DB_NAME', 'tutorme'); // Enter database name.
    
// Connect to database.    
    $conn = mysql_connect(DB_HOST, DB_USER, DB_PASS) or die ('Error connecting to mysql!');
    mysql_select_db(DB_NAME);

// Test if table exist.
    $query = mysql_query('SELECT 1 FROM schedule'); 
    
    if($query === false){
// If table doesn't exist a new one is created.        
        mysql_query('CREATE TABLE schedule (id INT, data TEXT)');
    }

?>