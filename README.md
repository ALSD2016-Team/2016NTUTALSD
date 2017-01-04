# 2016NTUTALSD
# Run Docker container

#Live Link: 
http://140.124.181.126:9092/

#certification

1. docker pull disc9562/alsddocker_certification
2. docker run -d -p 9090:8080 disc9562/alsddocker_certification
3. 開啟瀏覽器，輸入 localhost:9090/Certification 即可瀏覽

#invoice

1. docker pull disc9562/invoicepublish
2. docker run -d -p 9091:8080 disc9562/invoicepublish
3. 開啟瀏覽器，輸入 localhost:9091 即可瀏覽

# home

1. docker pull disc9562/homepublish
2. docker run -d -p 9092:8787 disc9562/homepublish
3. 開啟瀏覽器，輸入 localhost:9092 即可瀏覽

# sendMail

1. docker pull disc9562/mailpublish
2. docker run -d -p 9093:8080 disc9562/mailpublish
3. 開啟瀏覽器，輸入 localhost:9093/sendMail 即可瀏覽
