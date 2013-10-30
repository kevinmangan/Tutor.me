<?php

/*
* Title                   : Booking Calendar PRO (jQuery Plugin)
* Version                 : 1.2
* File                    : load.php
* File Version            : 1.0
* Created / Last Modified : 20 May 2013
* Author                  : Dot on Paper
* Copyright               : © 2011 Dot on Paper
* Website                 : http://www.dotonpaper.net
* Description             : Load booking data from a file.
*/

    if (isset($_POST['dopbcp_calendar_id'])){ // If calendar ID is received.
// Show file content.        
        $file = 'data/content'.$_POST['dopbcp_calendar_id'].'.txt';
        
        if (file_exists($file)){
            echo file_get_contents($file);
        }
        else{
            echo '';
        }
    }
    
?>