
var postApp = angular.module("mainModule", []);

 postApp.controller("cRUDController",[ '$scope', '$http', function ($scope, $http)
  {
	 $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
	 
	 $scope.sendPost = function()
	 {
		 
	        $http({
	            url : 'cRUDController',
	            method : "POST",
	            data : 
	            {
	            	'strStudentId' : $scope.strStudentId,
	            	'strStudentName' : $scope.strStudentName,
	                'strSubjectId' : $scope.strSubjectId,
	                'strGrade' : $scope.strGrade,
	                'ctrlAction' : $scope.ctrlAction
	                
	            }
	            
	        })
	        .then(
	        		
	        	function(response) 
	        	{
		            $scope.customMessage = response.data;
	        	},
	        	function(response) 
	        	{
		            $scope.customMessage =  "SUBMIT ERROR";		            
	        	}
	        	);
	        };
  }]);
 
 var createApp = angular.module("mainModule", []);
 
 createApp.controller('cRUDController', function ($scope)
 {
	 $scope.ShowMessage = true;
	 $scope.IsVisible = false;
	 $scope.checked = false;
	 $scope.isReadOnly = false;
	 $scope.TableShow = true;
	 $scope.VisibleUpdate = true;
	 $scope.VisibleDelete= true;
	 $scope.VisibleAdd = true;
	 
	 
	 $scope.ShowAdd = function ()
	 					{
		 					$scope.ShowMessage = false;
		 					$scope.IsVisible = false;	
		 					
		 					$scope.ctrlAction = "create";
		 					
		 					$scope.checked = false;
		 					$scope.strStudentId = "";
		 					$scope.strStudentName = "";
		 				 	$scope.strGrade = "";
		 				 	$scope.strSubjectId = "";
		 				 	$scope.isReadOnly = false;		
		 					$scope.IsVisible = true;
		 					$scope.TableShow = false;
		 					$scope.VisibleUpdate = false;
		 					$scope.VisibleDelete= false;
		 					$scope.VisibleAdd = false;
		 					
		 					
		 				}

	 $scope.setUpdateValues = function (stuId,stuName, stuGrade, strSubId)
		{	
		 	
		 	$scope.checked = true;
			$scope.strStudentId = stuId;
			$scope.strStudentName = stuName;
		 	$scope.strGrade = stuGrade;
		 	$scope.strSubjectId = strSubId;				 	
		}
	 
	 $scope.showUpdate = function (key)
		{
		 	$scope.ShowMessage = false;
		 	$scope.IsVisible = false;	
		 	
		 	if($scope.TableShow == true)
		 	{
		 		if($scope.checked == true)
			 	{
			 		$scope.IsVisible = true;
			 		$scope.isReadOnly = true;		
			 		$scope.ctrlAction = "update";
			 		$scope.TableShow = false;
			 		$scope.VisibleUpdate = false;
 					$scope.VisibleDelete= false;
 					$scope.VisibleAdd = false;
			 		
			 	}
			 	else
			 	{
			 		alert("Please select a Student.");
			 	}
		 	}
		 	else
		 	{
		 		$scope.TableShow = true;
		 	}		 	
		 			 	
		}
	 
	 $scope.showDelete = function ()
		{
		 	$scope.ShowMessage = false;
		 	$scope.IsVisible = false;
			$scope.TableShow = true;
		 
		 	if($scope.checked == true)
		 	{
		 		$scope.ctrlAction = "delete";
		 		$scope.strStudentId = stuId;
		 		$scope.VisibleUpdate = false;
					$scope.VisibleDelete= false;
					$scope.VisibleAdd = false;
		 		sendPost();
		 	}
		 	else
		 	{
		 		alert("Please select a Student.");
		 	}		 	
		}
	 
	 $scope.ShowViewAll = function()
	 {
		 $scope.ShowMessage = false;
		 $scope.IsVisible = false;
		 $scope.checked = false;
		 $scope.isReadOnly = false;
		 $scope.TableShow = true;
		 $scope.VisibleUpdate = true;
		 $scope.VisibleDelete= true;
		 $scope.VisibleAdd = true;
	 }
	 
	 $scope.showLogoutMessage = function() 
	 {
		    $scope.logoutmsg = true;
	 };
	 
	 
 });

 
 

