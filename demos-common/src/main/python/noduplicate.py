#!/usr/bin/python

import re


def noduplicate():
    apps = set()

    f = open("./appservices/services3")
    lines = f.readlines()
    f.close()
    for line in lines:
        if not line.strip() == '':
            for app in line.split():
                apps.add(app + ":" + app + "host")

                # print app + ":" + app + "host"

    print "##########################################################"

    f = open("./appservices/services1")
    lines = f.readlines()
    f.close()
    for line in lines:
        if not line.strip() == '':
            apps.add(line.replace('\n', ''))

            # print line.replace('\n', '')

    print len(apps)

    vipapps = set()
    f = open("./appservices/vipservices")
    lines = f.readlines()
    f.close()
    for line in lines:
        if not line.strip() == '':
            vipapps.add(line.replace('\n', ''))

    print len(vipapps)

    print len(apps - vipapps)
    otherapps = apps - vipapps
    for app in otherapps:
        print app


def main():
    print "we are in %s" % __name__
    noduplicate()


if __name__ == '__main__':
    main()
