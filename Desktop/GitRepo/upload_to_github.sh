#!/bin/bash

# Define the variable
repo_dir="//Users/azamat/Desktop/gh-academy-hw" #change this to the path of your local Github repo  
commit_message="Auto-upload new file"

# Navigate to the repository directory
cd "$repo_dir"

# Add all  new or modified files to the staging area
git add

# Commit the changes with the message 
git commit -m "$commit_message"

# Push the changes to the remote repository (Github)
git push origin master  #make sure 'main' is the correct branch (could be 'master')

echo "Files have been successfully uploaded to Github!"Computer systems and Industrial programming 


