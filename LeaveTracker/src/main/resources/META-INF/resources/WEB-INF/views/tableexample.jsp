<!doctype html>
<html lang="en">
    <head>
        <script language="javascript">
            function addRow(tableID) {
                var table = document.getElementById(tableID);
                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount); 
                var cell0 = row.insertCell(0);
                var element1 = document.createElement("input");
                element1.type = "text";
                var element2 = document.createElement("input");
                element1.type = "text";

                element1.name = "line"+(rowCount+1);
                element1.value=""+(rowCount+1);
                cell0.appendChild(element1);
                
                element2.name = "line"+(rowCount+1);
                element2.value=""+(rowCount+1);
                cell0.appendChild(element2);
                document.getElementById("countofrows").value=table.rows.length;
            }
        </script>

   </head>
   <body>
       <form name="" action="myjsp.jsp">
           <table  id="receiptTable">    
               <tr>
                   <td><input tye="text" name="line1" value="0"></td>
                   <input type="hidden" name="countofrows" id="countofrows">
               </tr>
           </table>
           <table>
               <tr>
                   <input type="button" name="addrow" onClick="addRow('receiptTable',this.form)" value="Add Line">
               </tr>
           </table>
       </form>
   </body>
</html>