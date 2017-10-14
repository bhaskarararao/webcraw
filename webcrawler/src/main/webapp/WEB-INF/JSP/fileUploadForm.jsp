<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<script type="text/javascript" src="jquery-1.2.6.min.js"></script>

<style>

body {
    background-color: #005073;
}
</style>

</head>
<body >
 <table>
 <tr>
 <td>
    <img src="images/cisco-logo.gif" width="30%" height="60%"/>
   </td>
   
   <td valign="top" align="right" height="100%" width="100%"> 
    <h3>Web Crawler</h3>
  </td>
  </table>
  <form:form method="post" enctype="multipart/form-data"
   modelAttribute="uploadedFile" action="submitFileUpload.htm">
   <table>
    <tr>
     <td>File Path: </td>
     <td><input type="file" name="file" />
     </td>
     <td style="color: red; font-style: italic;"><form:errors
       path="file" />
     </td>
    </tr>
    <tr><td>File location:</td><td><input type="text" name="filelocation"></td></tr>
    <tr><td>path:</td><td><input type="text" name="path"/></td></tr>
    <tr><td>querypath:</td><td><input type="text"name="qrypath"></td></tr>
    <tr><td>resultpath:</td><td><input type="text" name="resultpath"></td></tr>
    <tr><td></td></tr>
    <tr>
     <td><input type="submit" value="Submit request" />
     </td>
     <td> </td>
    </tr>
   </table>
  </form:form>
</body>
</html>

