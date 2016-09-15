/**
 * 
 */
app.controller('writeController', [ '$scope', 'uiGridConstants',
		function($scope, uiGridConstants) {

			$scope.refData = function() {
				$scope.gridOptions.data.length = DocArray.length;
				for(var i = 0; i < DocArray.length; i++){
					$scope.gridOptions.data[i].code = DocArray[i].code;
					$scope.gridOptions.data[i].title = DocArray[i].title;
					$scope.gridOptions.data[i].docType = DocArray[i].docType;
					$scope.gridOptions.data[i].reportingEntity = DocArray[i].reportingEntity;
					$scope.gridOptions.data[i].currency = DocArray[i].currency;
					$scope.gridOptions.data[i].residentCountry = DocArray[i].residentCountry;
					$scope.gridOptions.data[i].accountingStandard = DocArray[i].accountingStandard;
					$scope.gridOptions.data[i].reportingPeriod = DocArray[i].reportingPeriod;

				}
			};

			$scope.gridOptions = {
				enableRowSelection : true,
				enableRowHeaderSelection : false
			};

			$scope.gridOptions = {
				// enableSorting: true,
				columnDefs : [ {
					name : 'code',
					field : 'code'
				}, {
					name : 'title',
					field : 'title'
				}, {
					name : 'docType',
					field : 'docType'
				}, {
					name : 'reportingEntity',
					field : 'reportingEntity',
				}, {
					name : 'currency',
					field : 'currency',
				}, {
					name : 'residentCountry',
					field : 'residentCountry',
				}, {
					name : 'accountingStandard',
					field : 'accountingStandard',
				}, {
					name : 'reportingPeriod',
					field : 'reportingPeriod',
				} ],
				data : DocArray
			};

			$scope.gridOptions.multiSelect = false;
			$scope.gridOptions.modifierKeysToMultiSelect = false;
			$scope.gridOptions.noUnselect = true;
		} ]);