# =====================================================================
# PowerShell Script: Rebuild All Docker Services for ClassMate Project
# =====================================================================

# Step 1: Stop and remove all containers, networks, and volumes
Write-Host "Stopping and removing all containers, networks, and volumes..." -ForegroundColor Cyan
docker compose down --volumes

# Step 2: Remove dangling images to avoid stale jars
Write-Host "Removing dangling Docker images..." -ForegroundColor Cyan
docker image prune -f

# Step 3: Optionally, remove all old service images (forces full rebuild)
$serviceImages = @(
    "classmate_app-integrated-api-gateway",
    "classmate_app-integrated-course-service",
    "classmate_app-integrated-grade-service",
    "classmate_app-integrated-task-service",
    "classmate_app-integrated-reminder-service"
)

foreach ($image in $serviceImages) {
    Write-Host "Removing image: $image (if exists)..." -ForegroundColor Yellow
    docker rmi $image -f -ErrorAction SilentlyContinue
}

# Step 4: Build all images from scratch without cache
Write-Host "Building all Docker images without cache..." -ForegroundColor Cyan
docker compose build --no-cache

# Step 5: Start all services in detached mode
Write-Host "Starting all services..." -ForegroundColor Cyan
docker compose up -d

# Step 6: Wait a few seconds for containers to initialize
Write-Host "Waiting 10 seconds for services to start..." -ForegroundColor Cyan
Start-Sleep -Seconds 10

# Step 7: Display the status of all containers
Write-Host "Current running containers:" -ForegroundColor Green
docker ps

# Step 8: Optional: Display logs of API Gateway to check for errors
Write-Host "Tailing API Gateway logs for 10 seconds..." -ForegroundColor Green
docker compose logs -f --tail=50 api-gateway | ForEach-Object {$_}
Start-Sleep -Seconds 10

Write-Host "Rebuild and startup complete!" -ForegroundColor Green
