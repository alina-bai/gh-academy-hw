#!/bin/bash
commit_message="Auto-uploaded by script"

git add .
git commit -m "$commit_message"
git push origin main

echo "Files have been successfully uploaded to GitHub!"
