#!/usr/bin/python
def diff_stat():
    pre = set()
    f = open("./files/1_1.pre.csv")
    lines = f.readlines()
    f.close()
    for line in lines:
        print line
        pre.add(line.replace('\n', ''))

    host = set()
    f = open("./files/2_1.host.csv")
    lines = f.readlines()
    f.close()
    for line in lines:
        print line
        host.add(line.replace('\n', ''))

    print len(pre)
    print len(host)
    print pre - host
    print len(pre - host)


def main():
    print "we are in %s" % __name__
    diff_stat()


if __name__ == '__main__':
    main()
