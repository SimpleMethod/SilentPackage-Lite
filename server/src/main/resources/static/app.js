var app = angular.module("myApp", ["ngRoute", "ngCookies"]).controller("MultiController");
let urlAddress="http://127.0.0.1:8090/1.0/";
app.config(function($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl : './home.html',
            controller: 'HomeController'
        })
        .when("/processlist", {
            templateUrl : './processList.html',
            controller: 'ProcessListController'
        })
});



app.controller('HomeController', function ($scope, $http, $cookies, $interval) {

    $interval( function(){ $scope.get_telemetry(); }, 1000);
    $scope.get_telemetry = function () {

        $http({
            url: urlAddress+'cpu',
            method: 'GET',
            contentType: 'application/json'
        }).then(
            function (response) {
                $scope.cpuEnable=true;
                $scope.cpuCpuTemperature = response.data.CpuTemperature;
                $scope.cpuCpuClock = response.data.CpuClock;
                $scope.cpuCpuLoad = response.data.CpuLoad;

            },
            function () {
            }
        );

        $http({
            url: urlAddress+'motherboard',
            method: 'GET',
            contentType: 'application/json'
        }).then(
            function (response) {
                $scope.motherboardEnable=true;
                $scope.motherboardMemory = response.data.Memory;
                $scope.motherboardBiosVendor = response.data.BiosVendor;
                $scope.motherboardBiosVersion = response.data.BiosVersion;
                $scope.motherboardMainboardManufacturer = response.data.MainboardManufacturer;
                $scope.motherboardMainboardName = response.data.MainboardName;
                $scope.motherboardProcessorManufacturer = response.data.ProcessorManufacturer;
                $scope.motherboardProcessorVersion = response.data.ProcessorVersion;
                $scope.motherboardProcessorCoreCount = response.data.ProcessorCoreCount;
                $scope.motherboardProcessorThreadCount = response.data.ProcessorThreadCount;
                $scope.motherboardProcessorManufacturer = response.data.ProcessorManufacturer;
                $scope.motherboardProcessorVersion = response.data.ProcessorVersion;
                $scope.motherboardProcessorCoreCount = response.data.ProcessorCoreCount;
                $scope.motherboardProcessorThreadCount = response.data.ProcessorThreadCount;
            },
            function () {
            }
        );

        $http({
            url: urlAddress+'gpu',
            method: 'GET',
            contentType: 'application/json'
        }).then(
            function (response) {
                $scope.gpuEnable=true;
                $scope.gpuName = response.data.Name;
                $scope.gpuDriverVersion = response.data.DriverVersion;
                $scope.gpuDriverBranch=response.data.DriverBranch;
                $scope.gpuDeviceID=response.data.DeviceID;
                $scope.gpuRevisionID=response.data.RevisionID;
                $scope.gpuCurrentTemp=response.data.CurrentTemp;
                $scope.gpuTotalMemory=response.data.TotalMemory;
                $scope.gpuAvailableMemory=response.data.AvailableMemory;
            },
            function () {
            }
        );

        $http({
            url: urlAddress+'ram',
            method: 'GET',
            contentType: 'application/json'
        }).then(
            function (response) {
                $scope.ramEnable=true;
                $scope.ramTotalPhysicalMemory = response.data.TotalPhysicalMemory;
                $scope.ramTotalAvailableMemory = response.data.TotalAvailableMemory;
            },
            function () {
            }
        );

        $http({

            url:  urlAddress+'harddrive',
            method: 'GET',
            contentType: 'application/json'
        }).then(
            function (response) {
                $scope.hddEnable=true;
                $scope.hddArray = response.data.Drivers;
            },
            function () {
            }
        );

    };
});

app.controller('ProcessListController', function ($scope, $http) {
            $http({
                url:  urlAddress+'processlist',
                method: 'GET',
                contentType: 'application/json'
            }).then(
                function (response) {
                    $scope.records = response.data.ProcessList;
                },
                function () {
                }
            );
});
