fork a repository in the site at one of the addresses :
> mkdir myforkedrepository .
> cd myforkedrepository
> git clone https://github.com/gituser/gituserrepository.git
> git checkout -b my_fixes_to_the_repository
> nano folanfileofrepository.js
> make changes in nano and save it
> git commit -am "i fixed one of your bugs, == should be ==="
> git remote --set-upstream https://github.com/gituser/gitfolanrepo.git
> git remote add origin https://github.com/gituser/gitrepo.git // maybe this or above
> git push
> if didn't work , set the default with -M
> git branch -M my_fixes_to_the_repository
> git push

> then go to your forked repository
> push the pull request button . and then submit it for their review