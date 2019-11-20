$(document).ready(
	function() {
		switch (menu) {
		case 'About Us':
			$('#about').addClass('active');
			$('#home').removeClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			$('#home').removeClass('active');
			break;
		case 'All Products':
			$('#listProducts').addClass('active');
			$('#home').removeClass('active');
			break;
		default:
			$('#home').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
		}
		
		var products = [
						['1','Products1'],['2','Products2'],['3','Products3'],['4','Products4']
					];
		
//		 $('#productListTable').DataTable();
		var table = $('#productListTable');
		if(table.length){
			table.DataTable({
				data : products
			});
		}
//		$(document).ready( function () {
//		    $('#myTable').DataTable();
//		} );
	}
	
	
);