angular.module('form', [])
    .controller('Form', function ($scope, $http) {
        $scope.alphanumeric = '^[a-zA-Z0-9]+$';
        $scope.alpha = '^[a-zA-Z]+$';
        $scope.opts = [];
        $scope.data = {};
        $http.get('http://localhost:8080/options').
            then(function (response) {
                $scope.selects = response.data;
                let entries = Object.entries($scope.selects);
                let first = entries[0];
                $scope.selected = { "id": first[0], "value": first[1] };
                entries.map(item => {
                    $scope.opts.push({ "id": item[0], "value": item[1] });
                });
                console.log();
            });
        $scope.send = function (data) {
            data.type = $scope.selected.id;
            if ($scope.form.$valid) {
                $http.post('http://localhost:8080/', data)
                    .then(function (response) {
                        if (response.data)
                            console.log("Post Data Submitted Successfully!");
                    });
            }
        }
    });