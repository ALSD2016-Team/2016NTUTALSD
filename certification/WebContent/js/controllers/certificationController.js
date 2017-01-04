app.controller("CertificationController", ['$scope', '$state', '$timeout', '$rootScope',
    function($scope, $state, $timeout, $rootScope) {
        $scope.form = {
            studentName: "陳泰迪",
            certificationId: "SCRUM1603-33",
            courceDate: "於 2016 年 4 月 16、17、23 日-33",
            courceName: "Design Patterns 這樣學就會了：入門實作班",
            courceDuration: "全期共十八小時研習期滿，特此證明",
            certificationDate: "2016 年 4 月 23 日",


        }

        $scope.isDisabled = false;

        $scope.$watch('form', function(newValue, oldValue) {
            if ($scope.form.studentName && $scope.form.certificationId && $scope.form.courceDate && $scope.form.courceName && $scope.form.courceDuration && $scope.form.certificationDate){
                $scope.isDisabled = false
            }else {
                $scope.isDisabled = true
            }

        },true);

        var ClickGenerateButton = function() {
            var studentName = document.getElementById('studentName').value;
            var certificationId = document.getElementById('certificationId').value;
            var courceDate = document.getElementById('courceDate').value;
            var courceName = document.getElementById('courceName').value;
            var courceDuration = document.getElementById('courceDuration').value;
            var certificationDate = document.getElementById('certificationDate').value;

            var data = new Object();
            data.id_ = certificationId;
            data.owner_ = studentName;
            data.date_ = certificationDate;
            data.courceDate_ = courceDate;
            data.courceName_ = courceName;
            data.courceDuration_ = courceDuration;

            $.post("/Certification/CertificationServlet", JSON.stringify(data))
                .done(function(data) {
                    document.getElementById("someImg").setAttribute('src', 'data:image/png;base64,' + data);
                });
        }

        var ClickDownloadButton = function() {
            var imgData = document.getElementById("someImg").getAttribute('src');
            if (imgData != null) {
                var link = document.createElement('a');
                link.href = imgData;
                link.download = "Download.png";
                document.body.appendChild(link);
                link.click();
                document.body.removeChild(link);
            }
        }

        var ClickDownloadPDFButton = function() {
            var imgData = document.getElementById("someImg").getAttribute('src');

            if (imgData != null) {
                $.post("/Certification/CertificationServlet")
                    .done(function(data) {
                        var link = document.createElement('a');
                        link.href = 'data:application/pdf;base64,' + data;
                        link.download = document.getElementById("certificationId").value + " " + document.getElementById("studentName").value + ".pdf";
                        document.body.appendChild(link);
                        link.click();
                        document.body.removeChild(link);
                    });
            }
        }

        var init = function() {}

        $scope.ClickGenerateButton = ClickGenerateButton;
        $scope.ClickDownloadButton = ClickDownloadButton;
        $scope.ClickDownloadPDFButton = ClickDownloadPDFButton;
        /*==========================
            Events
        ==========================*/

        /*==========================
            Members
        ==========================*/

        /*==========================
             Methods
        ==========================*/

        /*==========================
             init
        ==========================*/

        init();
    }
]);
