mkdir -p "db/mongodb_data" || { echo "Error making folder";  exit  1; }
mkdir -p "start" || { echo "Error making folder";  exit  1; }
cd start || { echo "Error during folder creation";  exit  1; }
git clone https://(your_password)@github.com/suulaav/TheStart.git
wait
cd TheStart || { echo "TheStart folder not found, error during git clone";  exit  1; }
wait
cd backend || { echo "backend folder not found, error during git clone";  exit  1; }
wait
alias mvn17="export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-17.0.8.0.7-1.fc38.x86_64 && mvn"
mvn17 clean install
wait
cd ..
wait
docker-compose up -d --build
wait
