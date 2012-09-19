<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/JSPWedget/core" prefix="J" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page import="org.test.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
   
  
     <br> befor J:widget<br>
     <J:widget name="org.test.ExtendsWidget" key = "name" value="这是value"  /> 
     <br>end J:widget<br>
 
  </body>
</html>
