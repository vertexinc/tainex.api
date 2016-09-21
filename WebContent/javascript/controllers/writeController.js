/**
 * 
 */
app.controller('writeController',
		[
				'$scope',
				'$timeout',
				'$interval',
				'uiGridConstants',
				function($scope, $timeout, $interval, uiGridConstants) {
					// $scope.myOtherData = DocArray;

					$scope.refData = function() {
						$scope.gridOptions.data.length = 0;

						for (var i = 0; i < DocArray.length; i++) {
							$scope.gridOptions.data.push(DocArray[i]);
						}

						var newHeight = Math.floor(Math.random()
								* (300 - 100 + 1) + 300);

						angular.element(
								document.getElementsByClassName('grid')[0])
								.css('height', newHeight + 'px');
					};

					$scope.gridOptions = {
						enableRowSelection : true,
						enableRowHeaderSelection : false,

					};
					$scope.myRow = [];
					$scope.gridOptions = {
						// enableSorting: true,
						columnDefs : [ {
							name : 'id',
							field : 'id',
							visible : false
						}, {
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
						data : DocArray,
						onRegisterApi : function(gridApi) {
							$scope.gridApi = gridApi;
							gridApi.selection.on.rowSelectionChanged($scope,
									function(rows) {

										$scope.mySelections = gridApi.selection
												.getSelectedRows();
										console.log("what is row: "
												+ $scope.mySelections[0].id);
										// post tieDocID via ajax
										postDoc($scope.mySelections[0].id);
										$scope.refOtherTable();
									});
						}
					};
					$scope.mySelections = [];
					$scope.changeDelete = function()	 {
						console.log('Selection length = '
								+ $scope.mySelections.length);
					}
					$scope.gridOptions.multiSelect = false;
					$scope.gridOptions.modifierKeysToMultiSelect = false;
					$scope.gridOptions.noUnselect = false;

					$scope.refOtherTable = function() {
						$scope.gridOptions2.data.length = 0;

						for (var i = 0; i < EntityArray.length; i++) {
							$scope.gridOptions2.data.push(EntityArray[i]);
						}

						var newHeight = Math.floor(Math.random()
								* (300 - 100 + 1) + 300);

						angular.element(
								document.getElementsByClassName('grid2')[0])
								.css('height', newHeight + 'px');
					};

					$scope.gridOptions2 = {
						// enableSorting: true,
						columnDefs : [ {
							name : 'TIN',
							field : 'TIN'
						}, {
							name : 'Name',
							field : 'Name'
						}, {
							name : 'EntityCode',
							field : 'EntityCode'
						}, {
							name : 'DocType',
							field : 'DocType',
						}, {
							name : 'Incorporation Country',
							field : 'IncorporationCountry',
						}, {
							name : 'ResidentCountry',
							field : 'ResidentCountry',
						}, {
							name : 'IsPE',
							field : 'IsPE',
						}, {
							name : 'Address',
							field : 'Address',
						} ],
						data : EntityArray
					}
				} ]);