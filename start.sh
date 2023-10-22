mkdir -p "start/db/mongodb_data" || { echo "Error making folder";  exit  1; }
cd start || { echo "Error during folder creation";  exit  1; }
git clone https://github.com/suulaav/TheStart.git
wait
cd TheStart || { echo "TheStart folder not found, error during git clone";  exit  1; }
wait
cd backend || { echo "backend folder not found, error during git clone";  exit  1; }
wait
mvn clean install
wait
cd ..
wait
#cd frontend || { echo "frontend folder not found, error during git clone";  exit  1; }
#wait
docker-compose up -d --build
wait