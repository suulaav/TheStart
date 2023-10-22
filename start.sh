cd /opt || { echo "Cannot change dir to opt";  exit  1; }
wait
mkdir -p "start/db/mongodb_data" || { echo "Error making folder";  exit  1; }
cd start || { echo "Error during folder creation";  exit  1; }
git clone https://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@github.com/suulaav/TheStart.git
wait
cd TheStart || { echo "empty-bottle folder found error during git clone";  exit  1; }
mvn clean install
wait
docker-compose up -d --build
waitdocke