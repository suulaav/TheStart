mkdir -p "db/mongodb_data" || { echo "Error making folder";  exit  1; }
mkdir -p "start" || { echo "Error making folder";  exit  1; }
cd start || { echo "Error during folder creation";  exit  1; }
git clone https://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@github.com/suulaav/TheStart.git
wait
cd TheStart || { echo "TheStart folder not found, error during git clone";  exit  1; }
wait
cd backend || { echo "backend folder not found, error during git clone";  exit  1; }
wait
mvn clean install
wait
cd ..
docker-compose up -d --build
wait
