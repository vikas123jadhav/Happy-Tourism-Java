 function deleteConfirm(){
                return confirm("Are you sure , You want to Delete?");
           }

           $(document).ready(function(){
              $('#listTableCast').DataTable({
                 "pagingType":"full_numbers"
               });
            });